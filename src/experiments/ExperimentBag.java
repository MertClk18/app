package experiments;

import java.util.ArrayList;
import java.util.List;

//ExperimentBag Class
public class ExperimentBag {
 private List<Experiment> experiments;

 public ExperimentBag() {
     this.experiments = new ArrayList<>();
 }

 public void addExperiment(Experiment experiment) {
     experiments.add(experiment);
 }

 public List<Experiment> getExperiments() {
     return experiments;
 }
}