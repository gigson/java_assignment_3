package ge.btu.giorgi.kusikashvili.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class CovidService {

	private List<Covid> stats = new ArrayList<Covid>();

	public CovidService() {
		stats.add(new Covid("Georgia", 400, 10, 100));
		stats.add(new Covid("France", 500, 20, 200));
		stats.add(new Covid("Italy", 6000, 30, 300));
	}

	@WebMethod
	public List<Covid> getStatistics() {
		return stats;
	}

	@WebMethod
	public Covid getCountryStatistics(String country) throws Exception {
		for (Covid covid : stats) {
			if (covid.getCountry().equals(country)) {
				return covid;
			}
		}

		throw new Exception("country not found");
	}

	@WebMethod
	public int getTotalConfirmed() {
		int total = 0;

		for (Covid covid : stats) {
			total += covid.getConfirmed();
		}

		return total;
	}

	@WebMethod
	public int getTotalDeath() {
		int total = 0;

		for (Covid covid : stats) {
			total += covid.getDeath();
		}

		return total;
	}

	@WebMethod
	public int getTotalRecovery() {
		int total = 0;

		for (Covid covid : stats) {
			total += covid.getRecovered();
		}

		return total;
	}

}
