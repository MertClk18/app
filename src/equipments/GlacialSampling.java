package equipments;

import java.util.Random;
import experiments.Experiment;


import utilities.Position;

public class GlacialSampling extends Experiment {
    private int sampleWeight;

    public GlacialSampling(Position position) {
        super(position);
    }

    public int getSampleWeight() {
        return sampleWeight;
    }

    @Override
    public void perform() {
        this.sampleWeight = new Random().nextInt(20) + 1; // Random weight between 1 and 20 kg
        System.out.println("Glacial sampling performed at position " + getPosition().getX() + ", " + getPosition().getY() + ". Sample weight: " + sampleWeight + " kg.");
    }

	@Override
	public void report() {
		// TODO Auto-generated method stub
		
	}
}