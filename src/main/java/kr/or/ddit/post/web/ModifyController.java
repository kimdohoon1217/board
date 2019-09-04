package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.model.Attach;
import kr.or.ddit.post.model.Post;
import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.FileuploadUtil;

/**
 * Servlet implementation class ModifyController
 */
@WebServlet("/modifyPost")
@MultipartConfig(maxFileSize = 1024*1024*5*5, maxRequestSize = 1024*1024*5*5*5)
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ModifyController.class);
       
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostService();
	}
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Post post = new Post();
		post.setBoardNo(boardNo);
		post.setBullNo(postNo);
		
		Post vo = postService.getPost(post);
		
		List<Attach> fileList = postService.getFile(postNo);
		
		
		request.setAttribute("vo", vo);
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("/board/modiForm.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("pTitle");
		logger.debug("{}", title);
		String cont = request.getParameter("cont");
		logger.debug("{}", cont);
		int postNo = Integer.parseInt(request.getParameter("mPostNo"));
		logger.debug("pNo - {}", postNo);
		int seq = Integer.parseInt(request.getParameter("mBoardSeq"));
       logger.debug("seq = {}",seq);
       
       Post post = new Post();
       post.setBullTitle(title);
       post.setBullCont(cont);
       post.setDelStatus("X");
       post.setBullNo(postNo);
       
       postService.updatePost(post);
	
      List<Part> files = (List<Part>) request.getParts();
      logger.debug("files-size : {}", files.size());
      List<Part> pList = new ArrayList<Part>();
        String fileName = "";
        String path = "";
        int filNo = 0;
        if (files.size() > 0) {
            for (Part part : files) {
            	logger.debug("{}", part.getName());
                if (part.getName().equalsIgnoreCase("regFile")) {
                    fileName = FileuploadUtil.getFilename(part.getHeader("Content-Disposition"));
                    logger.debug("content-disposition - {}", part.getHeader("Content-Dispostion"));
                    logger.debug("filename - {}", fileName);
                    if(!fileName.equals("")) {
                        String realFileName = UUID.randomUUID().toString();
                        String ext = FileuploadUtil.getFilename(part.getHeader("Content-Disposition"));
                        path = FileuploadUtil.getPath() + realFileName + ext;

                        part.write(path);

//                        Map fileMap = new HashMap();
//                        fileMap.put("UPLOADFILE", fileName);
//                        fileMap.put("FILEPATH", path);
                        
                        Attach attach = new Attach();
                        attach.setUploadFile(fileName);
                        attach.setFilePath(path);
                        attach.setBullNo(postNo);

                        int res = postService.insertFile(attach);
                        logger.debug("수정 성공1111111 - {}", res);
                    }
                }
            }
         
            
            //postNo , boardNo 를 가지고 redirect를 해준다 postController
        }
        //"&filNo=" + filNo 파일넘버도 보내줘야함
        response.sendRedirect(request.getContextPath() + "/post?boardNo=" + seq + "&postNo=" + postNo);
	}

}
