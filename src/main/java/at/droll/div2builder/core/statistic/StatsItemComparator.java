package at.droll.div2builder.core.statistic;

import java.util.Comparator;

/**
 * StatsItemComparator
 * @author Marco Droll
 */
public class StatsItemComparator implements Comparator<StatsItem> {
	
	/**
	 * Compare method for two StatsItem to sort it wit the Collection.sort method 
	 * @param o1 StatsItem object 1 to compare
	 * @param o2 StatsItem object 2 to compare
	 * @return Returns the mathematical results which are needed for sort
	 */
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
