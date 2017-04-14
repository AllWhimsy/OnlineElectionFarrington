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
 * Servlet implementation class AddElectionServlet
 */
@WebServlet("/AddElectionServlet")
public class AddElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddElectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String election = request.getParameter("election");
		String cand1Name = request.getParameter("Cand1Name");
		String cand2Name = request.getParameter("Cand2Name");
		String cand3Name = request.getParameter("Cand3Name");
		

		CandidateItem ci = new CandidateItem(election, cand1Name, cand2Name, cand3Name);
		ElectionDAO dao = new ElectionDAO();
		dao.insertNewElection(ci);
		getServletContext().getRequestDispatcher("/ViewElectionsServlet").forward(request, response);
	}

}
