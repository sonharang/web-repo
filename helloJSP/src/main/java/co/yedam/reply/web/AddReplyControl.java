package co.yedam.reply.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class AddReplyControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		ReplyVO vo = new ReplyVO();
		ReplyService svc = new ReplyServiceImpl();
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		
		System.out.println(bno);
		vo.setBoardNo(Integer.parseInt(bno));
		
		vo.setReply(reply);
		vo.setReplyer(replyer);
		vo.setReplyDate(new Date());

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		Map<String, Object> map = new HashMap<>();

		if (svc.addReply(vo)) {
			map.put("retCode", "OK");
			map.put("vo", vo);
		} else {
			try {
				map.put("retCode", "NG");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// excute

}// command
