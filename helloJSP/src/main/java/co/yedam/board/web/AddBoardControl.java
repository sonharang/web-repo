package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class AddBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		BoardVO vo = new BoardVO();
		BoardService svc = new BoardServiceImpl();
		if (req.getMethod().equals("GET")) { // GET방식

			// 제목, 내용, 작성자
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

		} // end of if
		else if (req.getMethod().equals("POST")) { // POST방식
			String saveDir = req.getServletContext().getRealPath("images"); // webapp 밑의 images폴더
			int size = 5 * 1024 * 1024;
			// MultipartRequest mr; 멀티파트 처리
			try {
				MultipartRequest mr = //
						new MultipartRequest(req, // 요청정보
								saveDir, // 저장경로
								size, // 최대업로드 할 수 있는 파일의 크기
								"UTF-8", // 인코딩 방식
								new DefaultFileRenamePolicy() // 리네임 정책(똑같은 파일 이름 처리)
						);
				String title = mr.getParameter("title");
				String writer = mr.getParameter("writer");
				String content = mr.getParameter("content");
				String img = mr.getFilesystemName("img");

				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
				vo.setImage(img);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end of if
		if (svc.addBoard(vo)) {
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("boardForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// excute

}// command
