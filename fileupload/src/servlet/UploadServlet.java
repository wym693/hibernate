package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet  extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//构建文件工厂并且设置缓存文件夹
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items =null;
		try {
			items=upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			System.out.println("解析请求异常");
		}
			
		//循环处理文件
		// Process the uploaded items
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
		    FileItem item = iter.next();

		    if (item.isFormField()) {
		        processFormField(item);
		    } else {
		        processUploadedFile(item,request);
		    }
		}
		
		response.getWriter().write("<script>alert('Success!');</script>");
		
		response.getWriter().flush();
		
		
		
		
		
		
		
		
	}
	//文件
	private void processUploadedFile(FileItem item,HttpServletRequest request) {
		
		//获取upload在服务器运行时候的绝对路径
		String uploadLocation=request.getSession().getServletContext().getRealPath("upload");
		
		System.out.println("upload="+uploadLocation);
		
		//获得待保存的文件名
		String fileName=item.getName();
		
		String fieldName = item.getFieldName();
	    String contentType = item.getContentType();
	    boolean isInMemory = item.isInMemory();
	    //文件大小
	    long sizeInBytes = item.getSize();
		
		
		//保存到服务器的指定文件夹，+保存数据库
		File folder=new File(uploadLocation);
		//文件保存路径
		File uploadFild=new File(folder,fileName);
		
		//写入文件
		try {
			item.write(uploadFild);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件写入成功失败");
		}
		System.out.println("文件写入成功");
		
	
		
		
		
		
	}
	//普通的文本域
	private void processFormField(FileItem item) {
		
		String filedName=item.getFieldName();
	    String filedValue=item.getString();
	    System.out.println(filedName+"="+filedValue);
		
	}

}
