package ir.ac.kntu.cs2d.model;

import java.util.*;

public class AgentManager {
    private HashMap<GameSide, ArrayList<Gamer>> agents;

    public AgentManager(){
        agents = new HashMap<>();
        agents.put(GameSide.CT, new ArrayList<>());
        agents.put(GameSide.TERROR, new ArrayList<>());
    }

    public void add(Gamer person){
        if(getAgents().get(person.getAgent().getGameSide()).size() > 4){
            throw new IndexOutOfBoundsException();
        }
        getAgents().get(person.getAgent().getGameSide()).add(person);
    }

    private List<Gamer> getCT() {
        return agents.get(GameSide.CT);
    }

    private List<Gamer> getTerror() {
        return agents.get(GameSide.TERROR);
    }

    private HashMap<GameSide, ArrayList<Gamer>> getAgents() {
        return agents;
    }

    public Gamer getAgent(int id) throws ClassNotFoundException {
        for(Map.Entry gameSide: agents.entrySet()){
            for (Gamer gamer: agents.get(gameSide)){
                if(gamer.getId() == id){
                    return gamer;
                }
            }
        }
        throw new ClassNotFoundException();
    }

    public void removeAgent(Gamer gamer) {
        getAgents().get(gamer.getAgent().getGameSide()).remove(gamer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AgentManager that = (AgentManager) o;
        return Objects.equals(agents, that.agents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agents);
    }
}
