package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CandidateItem;
import model.ElectionDAO;

//Michelle Farrington
/**
 * Servlet implementation class MasterControllerServlet
 */
@WebServlet("/MasterControllerServlet")
public class MasterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Master Controller Servlet");

		ElectionDAO dao = new ElectionDAO();

		String actionToPerform = request.getParameter("doThis");
		if (actionToPerform.equals("Add New Election")) {
			System.out.println("Launch us to add election");
			getServletContext().getRequestDispatcher("/add-election.jsp").forward(request, response);

		} else if (actionToPerform.equals("Select Election")) {
			System.out.println("Launch to Vote Screen");

			int tempId = Integer.parseInt(request.getParameter("id"));
			System.out.println(tempId);
			CandidateItem electionPicked = dao.getAllCandidates().get(tempId);
			request.setAttribute("itemId", tempId + "");
			request.setAttribute("Election", electionPicked.getElection());
			request.setAttribute("Cand1Name", electionPicked.getCand1Name());
			request.setAttribute("Cand2Name", electionPicked.getCand2Name());
			request.setAttribute("Cand3Name", electionPicked.getCand3Name());

			getServletContext().getRequestDispatcher("/voting-booth.jsp").forward(request, response);
		}

		doGet(request, response);
	}

}
