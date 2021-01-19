/* ******************************************************
 * Simulator alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: algorithms/RandomWalker.java 2015-03-09 buixuan.
 * ******************************************************/
package algorithm;

import specifications.AlgorithmService;
import specifications.SimulatorService;
import specifications.RequireSimulatorService;

import java.util.Random;

public class RandomWalker implements AlgorithmService, RequireSimulatorService{
  private SimulatorService simulator;
  private Random gen;

  public RandomWalker() {
    gen = new Random();
  }

  @Override
  public void bindSimulatorService(SimulatorService service){
    simulator = service;
  }

  @Override
  public void activation(){
    simulator.moveRight();
  }
  
  @Override
  public void stepAction(){
    switch (gen.nextInt(4)){
      case 0:
        simulator.moveRight();
        break;
      case 1:
        simulator.moveLeft();
        break;
      case 2:
        simulator.moveDown();
        break;
      case 3:
        simulator.moveUp();
      default:
        break;
    }

    switch (gen.nextInt(4)){
      case 0:
        simulator.moveOtherRight();
        break;
      case 1:
        simulator.moveOtherLeft();
        break;
      case 2:
        simulator.moveOtherDown();
        break;
      case 3:
        simulator.moveOtherUp();
      default:
        simulator.moveOtherRight();
        break;
    }
  }
}
