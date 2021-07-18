package at.droll.div2builder.core.statistic;

import java.util.Comparator;

public class StatsItemComparator implements Comparator<StatsItem> {
	
	@Override
	public int compare(StatsItem o1, StatsItem o2) {
		
		if (o1.getAttribute().toLowerCase().compareTo(o2.getAttribute().toLowerCase())<1) {
			return -1;
		} else if (o1.getAttribute().toLowerCase() .compareTo(o2.getAttribute().toLowerCase())>1) {
			return 1;
		} else {
			return 0;
		}
	}
}
