package com.xk.reader.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import com.xk.reader.bean.BookMixAToc;


import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class DownloadService extends Service{

	public static final String DOWNLOAD_MUSIC = "DOWNLOAD_MUSIC";
	private LinkedBlockingQueue<BookMixAToc.mixToc.Chapters> queue = new LinkedBlockingQueue<BookMixAToc.mixToc.Chapters>();
	
	
	private boolean running = true;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("com.xk.kreader","addTask");
		BookMixAToc.mixToc.Chapters info = (BookMixAToc.mixToc.Chapters) intent.getSerializableExtra("info");
		if(null != info) {
			try {
				queue.put(info);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.onStartCommand(intent, flags, startId);
	}


	@Override
    public void onCreate()
    {
		Log.i("com.xk.kreader","onCreate");
        super.onCreate();
        doTasks();
        
    }

    @Override
    public void onDestroy()
    {
    	Log.i("com.xk.kreader","onDestroy");
        super.onDestroy();
        running = false;
        
    }
    
    private void doTasks() {
    	Thread t = new Thread(new Runnable() {
			

			@Override
			public void run() {
				while(running) {
					try {
						BookMixAToc.mixToc.Chapters info = queue.take();
						if(null == info) {
							stopSelf();
							Log.i("com.xk.kreader", "no more task,exit service");
							return;
						}
						//开始下载
						
						Log.i("com.xk.kreader", "looping!!!!");
					} catch (Exception e) {
						e.printStackTrace();
						Log.e("com.xk.kreader", "下载队列出错！！" + e.getMessage());
					}
				}
				
			}
		});
    	t.start();
    }
    
    
    
    /**
     * 先将歌曲用临时文件存起来，然后重命名。防止下载一半就失败了，留下垃圾文件
     * @param temp
     * @param file
     * @param loc
     * @throws IOException
     */
    private void saveToFile(File temp,File file, InputStream loc) throws IOException{
    	FileOutputStream out = null;
    	try {
			temp.createNewFile();
			out = new FileOutputStream(temp);
			byte[]buf = new byte[20480];
			int len = 0;
			while((len=loc.read(buf, 0, buf.length))>=0){
				out.write(buf, 0, len);
				out.flush();
			}
			temp.renameTo(file);
		} catch (IOException e) {
			throw e;
		}finally {
			if(null != out) {
				out.close();
			}
		}
		
    }
    
    
    /**
     * 添加到下载队列
     * @param context
     * @param info
     */
    public static void addDownloadTask(Context context, BookMixAToc.mixToc.Chapters info) {
    	Intent intent = new Intent(context,DownloadService.class);
    	intent.setAction(DOWNLOAD_MUSIC);
    	intent.putExtra("info", info);
    	context.startService(intent);
    }

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
}
