package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
//Michelle Farrington

public class ElectionDAO {
	Connection con = null;

	public ElectionDAO() {

	}

	public void makeConnection() {
		String url = "jdbc:mysql://localhost:3306/election";
		String user = "root";
		String password = "DIAD2016";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Made");

		} catch (Exception ex) {
			System.out.println("Sql Connection Failed");
		}
	}

	public ArrayList<CandidateItem> getAllCandidates() {
		ArrayList<CandidateItem> allCandidates = new ArrayList<CandidateItem>();
		makeConnection();
		String q = "SELECT * from election";
		
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);

			while (rs.next()) {
				String election = rs.getString(2);
				String cand1Name = rs.getString(3);
				String cand2Name = rs.getString(4);
				String cand3Name = rs.getString(5);
				CandidateItem temp = new CandidateItem(election, cand1Name, cand2Name, cand3Name);
				allCandidates.add(temp);

				System.out.println(temp);
			}
		} catch (SQLException ex) {
			System.out.println("SQL Error in getAllCandidates() method");
			System.out.println(ex.getStackTrace());

		}
		return allCandidates;
	}

	public HashSet<String> getUniqueElections() {
		ArrayList<String> allElections = new ArrayList<String>();
		for (CandidateItem p : getAllCandidates()) {
			allElections.add(p.getElection());
		}

		// TELLS WHICH LIST TO TURN INTO A HASHSET
		HashSet<String> uniqueElections = new HashSet<String>(allElections);
		return uniqueElections;
	}

	public ArrayList<String> getCurrentCandsFromElection(String e) {
		ArrayList<String> allCandsFromSelectedElection = new ArrayList<String>();
		for (CandidateItem p : getAllCandidates()) {
			if (p.getElection().equals(e)) {
				allCandsFromSelectedElection.add(p.getCand1Name());
				allCandsFromSelectedElection.add(p.getCand2Name());
				allCandsFromSelectedElection.add(p.getCand3Name());

			}
		}

		return allCandsFromSelectedElection;
	}

	public void insertNewElection(CandidateItem i) {
		// TODO Auto-generated method stub
		String tempElection = i.getElection();
		String tempCand1Name = i.getCand1Name();
		String tempCand2Name = i.getCand2Name();
		String tempCand3Name = i.getCand3Name();

		String query = "insert into election (election, cand1name, cand2name, cand3name) values ('" + tempElection
				+ "', '" + tempCand1Name + "', '" + tempCand2Name + "', '" + tempCand3Name + "')";
		System.out.println(query);
		
		try {
			Statement st = (Statement) con.createStatement();

			st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
