package tour;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import search.Action;
import search.State;

public class TourState implements State {
	protected final Set<City> visitedCities;
	protected final City currentCity;
	
	public TourState(City startCity) {
		this.visitedCities = Collections.emptySet();
		this.currentCity = startCity;
	}
	public TourState(Set<City> visitedCities, City currentCity) {
		this.visitedCities = visitedCities;
		this.currentCity = currentCity;
	}
	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;
	}
	public State getActionResult(Action action) {
		Road road = (Road)action;
		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);
		newVisitedCities.add(road.targetCity);
		return new TourState(newVisitedCities, road.targetCity);
	}
	
	public boolean equals(Object that){
		if(this == that){
			return true;
		}
		else if (that instanceof TourState){
			TourState t = (TourState) that;
			if(t.currentCity == this.currentCity && t.visitedCities.equals(this.visitedCities)){
				return true;
			}
		}
		return false;
	}
	
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (null == currentCity ? 0 : currentCity.hashCode());
		hash = 31* hash + visitedCities.hashCode();
		return hash;
	}
}
