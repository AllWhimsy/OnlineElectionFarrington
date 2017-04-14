package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CandidateItem;
import model.ElectionTally;

//Michelle Farrington
/**
 * Servlet implementation class resultsServlet
 */
@WebServlet("/resultsServlet")
public class resultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultsServlet() {
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
		
		ElectionTally elect = new ElectionTally();
		
		String voteCand = request.getParameter("CandName");
		if (voteCand.equals("tempCand1Name")) {
			elect.votesForCandidateOne();
			System.out.println("Vote Cast Candidate One");
		} else if (voteCand.equals("tempCand2Name")) {
			elect.votesForCandidateTwo();
		} else if (voteCand.equals("tempCand3Name")) {
			elect.votesForCandidateThree();
		}
		
		request.setAttribute("Cand1Name", "tempCand1Name");
		request.setAttribute("Cand2Name", "tempCand2Name");
		request.setAttribute("Cand3Name", "tempCand3Name");
		
		request.setAttribute("Cand1Votes", elect.getTotalVotesOne());
		request.setAttribute("Cand2Votes", elect.getTotalVotesTwo());
		request.setAttribute("Cand3Votes", elect.getTotalVotesThree());
		
		getServletContext().getRequestDispatcher("/election-results.jsp").forward(request, response);
	}

}
