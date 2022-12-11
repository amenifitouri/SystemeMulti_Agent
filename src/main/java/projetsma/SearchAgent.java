package projetsma;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.util.leap.Iterator;

public class SearchAgent extends Agent {
    protected void setup() {
        System.out.println("salut je suis "+this.getLocalName()+" ,je cherche une ambulance");
        this.searchAgents();
    }
    private void searchAgents() {
        DFAgentDescription dfd = new DFAgentDescription();
        //ajouter le service à retrouver
        ServiceDescription sd = new ServiceDescription();
        sd.setType( "construction" );
        dfd.addServices(sd);
        try {
            DFAgentDescription[] result = DFService.search(this, dfd);
            for (int i=0; i<result.length; i++) {
                String out = result[i].getName()+" provides";
                Iterator iter = result[i].getAllServices();
                while (iter.hasNext()) {
                    sd = (ServiceDescription)iter.next();
                    out += " "+sd.getName();
                }
                System.out.println(this.getLocalName()+": "+out);
            }
        }
        catch (Exception fe) {
            System.err.println(getLocalName() + " search with DF unsucceeded - "
                            + fe.getMessage());
            doDelete();
        }
    }
}