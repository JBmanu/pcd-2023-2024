package pcd.ass01.simtrafficexamples;

import pcd.ass01.simengineseq.AbstractSimulation;
import pcd.ass01.simtrafficbase.CarAgent;
import pcd.ass01.simtrafficbase.CarAgentBasic;
import pcd.ass01.simtrafficbase.P2d;
import pcd.ass01.simtrafficbase.Road;
import pcd.ass01.simtrafficbase.RoadsEnv;

/**
 * 
 * Traffic Simulation about a number of cars 
 * moving on a single road, no traffic lights
 * 
 */
public class TrafficSimulationSingleRoadSeveralCars extends AbstractSimulation {

	public TrafficSimulationSingleRoadSeveralCars() {
		super();
	}
	
	public void setup() {

		this.setupTimings(0, 1);

		final RoadsEnv env = new RoadsEnv();
		this.setupEnvironment(env);
		
		final Road road = env.createRoad(new P2d(0,300), new P2d(1500,300));

		final int nCars = 30;

		for (int i = 0; i < nCars; i++) {
			
			final String carId = "car-" + i;
			// double initialPos = i*30;
			final double initialPos = i*10;
			
			final double carAcceleration = 1; //  + gen.nextDouble()/2;
			final double carDeceleration = 0.3; //  + gen.nextDouble()/2;
			final double carMaxSpeed = 7; // 4 + gen.nextDouble();
						
			final CarAgent car = new CarAgentBasic(carId, env,
									road,
									initialPos, 
									carAcceleration, 
									carDeceleration,
									carMaxSpeed);
			this.addAgent(car);
		}
		
		this.syncWithTime(25);
	}	
}
	