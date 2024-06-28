package org.example.service;

import org.example.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component // as service, just different name
public class CommissionHandlerStrategy {
    //    @Autowired
//    @Qualifier("goldCommissionHandler")
//    private CommissionHandler goldCommissionHandler;
//
//    @Autowired
//    @Qualifier("usualCommissionHandler")
//    private CommissionHandler usualCommissionHandler;
//
//    public CommissionHandler getHandler(Card.CardType cardType){
//         if (cardType.equals(Card.CardType.GOLD)) {
//             return goldCommissionHandler;
//         } else {
//             return usualCommissionHandler;
//         }
//    }
    @Autowired
    private List<CommissionHandler> commissionHandlers;

    public CommissionHandler getHandler(Card.CardType cardType) {
        return commissionHandlers.stream()
                .filter(h -> h.isApplicable(cardType))
                .findFirst().orElseThrow(NoSuchElementException::new);
    }
}
