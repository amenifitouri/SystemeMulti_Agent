package projetsma;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.behaviours.SimpleBehaviour;
public class ReceiverBehaviour extends SimpleBehaviour {
    private static final MessageTemplate mt =
            MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    public ReceiverBehaviour(Agent agent) {
        super(agent);
    }
    public void action() {
        ACLMessage msg = myAgent.receive(mt);
        if (msg!=null) {
            System.out.println(myAgent.getLocalName()+":I received message.\n"
                            +msg.toString());
        }
        else {
            this.block();
        }
    }
    //retun true 1 fois return flase cyclique
    public boolean done() {
        return false;
    }
}