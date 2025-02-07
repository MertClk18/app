package lake;

import Presentation.Researcher;
import utilities.Position;

public abstract class Hazard {
    private Position position;

    public Hazard(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void interact(Researcher researcher);
}