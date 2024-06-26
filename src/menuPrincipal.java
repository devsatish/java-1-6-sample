/* menuPrincipal.java
 * Created on 26-OCT-2011, 13:42:24 */

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class menuPrincipal extends javax.swing.JFrame {

    /** Creates new form menuPrincipal */
    public menuPrincipal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        labelYourCards 		= new javax.swing.JLabel();
        textFieldHandOne 	= new javax.swing.JTextField();
        labelOpponentOne 	= new javax.swing.JLabel();
        textFieldHandTwo 	= new javax.swing.JTextField();
        labelBoard 			= new javax.swing.JLabel();
        textFieldBoard 		= new javax.swing.JTextField();
        buttonCalculate 	= new javax.swing.JButton();
        buttonReset 		= new javax.swing.JButton();
        labelResult 		= new javax.swing.JLabel();
        labelDeadCards 		= new javax.swing.JLabel();
        textFieldDeadCards 	= new javax.swing.JTextField();
        jMenuBar 			= new javax.swing.JMenuBar();
        menuArchivo 		= new javax.swing.JMenu();
        menuEditar 			= new javax.swing.JMenu();
        menuAyuda 			= new javax.swing.JMenu();
        jMenuItem1 			= new javax.swing.JMenuItem();

        /* ends the java process on window close event */
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        /* title of the window */
        setTitle("Poker Odds Calculator");

        labelYourCards.setText("Your Cards:");

        labelOpponentOne.setText("Opponent 1:");

        labelBoard.setText("Board:");

        buttonCalculate.setText("Calculate");
        buttonCalculate.addActionListener(evt -> buttonCalculateActionPerformed(evt));

        buttonReset.setText("Reset");

        labelResult.setFont(new java.awt.Font("Tahoma", 0, 14));
        labelResult.setText("Odds:");

        labelDeadCards.setText("Dead Cards: ");

        menuArchivo.setText("Archivo");
        menuArchivo.setToolTipText("");
        jMenuBar.add(menuArchivo);

        menuEditar.setText("Editar");
        jMenuBar.add(menuEditar);

        menuAyuda.setText("Ayuda");

        jMenuItem1.setText("About");
        menuAyuda.add(jMenuItem1);

        jMenuBar.add(menuAyuda);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelYourCards, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelOpponentOne))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldHandOne)
                            .addComponent(textFieldHandTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCalculate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReset)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBoard)
                            .addComponent(labelDeadCards))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldDeadCards)
                            .addComponent(textFieldBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCalculate, buttonReset});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelYourCards, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldHandOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBoard))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelOpponentOne)
                            .addComponent(textFieldHandTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDeadCards)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldDeadCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCalculate)
                    .addComponent(buttonReset)
                    .addComponent(labelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pack();

    }// </editor-fold>//GEN-END:initComponents

private void buttonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalculateActionPerformed

    String[] boardArray;
    String[] handOneArray;
    String[] handTwoArray;

    int numberOfHands = 10000;		// set the number of times the hand is going to be played
    int count_player_one_wins = 0;	// count the number of times player one wins the hand
    int count_player_two_wins = 0;	// count the number of times player two wins the hand
    int tie = 0;					// count the number of times the hand results in a tie
    int ranking_hand_one = 0;		// saves the value of player one current hand in numeric form
    int ranking_hand_two = 0;		// saves the value of player two current hand in numeric form
    Deck deck = new Deck();			// initializes a new Deck object
    Hand handPlayerOne;				// initializes a new Hand object for player one
    Hand handPlayerTwo;				// initializes a new Hand object for player two

    Hand best_hand_one = new Hand(); // this Hand object is used to save the best five card combination for player one	
    Hand best_hand_two = new Hand(); // this Hand object is used to save the best five card combination for player two	

    /** 
     * Set up the hands for the two players
     */
    String handOne = this.textFieldHandOne.getText();
    if("".equals(handOne)){
        JOptionPane.showMessageDialog(null, "\nPlayer one hand can't be an empty hand, \nYou must enter a hand in this format: \n\n"
               + "As,Td,4c or Kd6c9s", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }else{
        handOne = handOne.replaceAll("\\s","");		// remove all the whitespace from the string
        handOneArray = handOne.split(",");	// divide the string into an array

        /** 
	     * if the array contains only one element there are two posible scenarios
	     * the player only enetered 1 card or the player forgot to put commas in his query.
	     */
        if(handOneArray.length == 1){
	        String putTheCommas = handOneArray[0];
	        /* for loop to put commas in place */
	        for(int i=2; i<putTheCommas.length(); i+=2){
		       putTheCommas = putTheCommas.substring(0, i) + "," + putTheCommas.substring(i, putTheCommas.length());
	        }

	        handOne = putTheCommas.substring(0, putTheCommas.lastIndexOf(",")); // remove trailing comma
	        Arrays.fill(handOneArray, null);   // empty the array
	        handOneArray = handOne.split(","); // this time we know the commas are there
        }

        handPlayerOne = new Hand(handOneArray);
        deck.removeCards(handOneArray);
        if(handPlayerOne.getTotalCards()>5){
            JOptionPane.showMessageDialog(null, "More than 5 cards is not allowed.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }

    /* SAME METHOD FOR PLAYER TWO HAND */
    String handTwo = this.textFieldHandTwo.getText();
    if("".equals(handTwo)){
        JOptionPane.showMessageDialog(null, "\nPlayer two must have at least one card: \n\nYou must enter a hand in this format: \n\n"
               + "As,Td,4c or Kd6c9s", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }else{
    	handTwo = handTwo.replaceAll("\\s","");			// remove all the whitespace from the string
        handTwoArray = handTwo.split(",\\s*");	// divide the string into an array

        if(handTwoArray.length == 1){
	        String putTheCommas = handTwoArray[0];

	        for(int i=2; i<putTheCommas.length(); i+=2){
		       putTheCommas = putTheCommas.substring(0, i) + "," + putTheCommas.substring(i, putTheCommas.length());
	        }

	        handTwo = putTheCommas.substring(0, putTheCommas.lastIndexOf(",")); // remove trailing comma
	        Arrays.fill(handTwoArray, null);   // empty the array
	        handTwoArray = handTwo.split(","); // this time we know the commas are there
        } 

        handPlayerTwo = new Hand(handTwoArray);
        deck.removeCards(handTwoArray);
        if(handPlayerTwo.getTotalCards()>5){
            JOptionPane.showMessageDialog(null, "More than 5 cards each player is not allowed.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }



  	/** 
     * Check if there are any cards on the board and play the hand
     * No cards in board means the hand is to be played with series of random boards
     */
    String board = this.textFieldBoard.getText();
    if("".equals(board)){ 

        for(int i=0; i<numberOfHands; i++){

            Hand playerOne = new Hand(handPlayerOne);
            Hand playerTwo = new Hand(handPlayerTwo);
            Deck deckLeft  = new Deck(deck);
            deckLeft.shuffle();

            Hand temp_hand 		= new Hand();
            Hand temp_hand_two 	= new Hand();

            while(playerOne.getTotalCards() < 5){
                playerOne.addCard(deckLeft.dealCard());
            }
            while(playerTwo.getTotalCards() < 5){
                playerTwo.addCard(deckLeft.dealCard());
            }

            evaluateHand(playerOne); //System.out.println("Mano original UNO: " + playerOne.handToString() + " hand rank:" + playerOne.getHandRank());
            evaluateHand(playerTwo); //System.out.println("Mano original DOS: " + playerTwo.handToString() + " hand rank:" + playerTwo.getHandRank());


            for(int dc=0; dc<5; dc++){
                //System.out.println("Entra al for(dc) para deep copy");
                Card card_temp1 = playerOne.getCard(dc);
                Card deepCopy1 = new Card(card_temp1.getRank(), card_temp1.getSuit());
                best_hand_one.addCard(deepCopy1);  
            }
            for(int dc=0; dc<5; dc++){
                //System.out.println("Entra al for(dc) para deep copy");
                Card card_temp2 = playerTwo.getCard(dc);
                Card deepCopy2 = new Card(card_temp2.getRank(), card_temp2.getSuit());
                best_hand_two.addCard(deepCopy2);  
            }

            best_hand_one.setHandRank(playerOne.getHandRank());
            best_hand_two.setHandRank(playerTwo.getHandRank());

            //System.out.println("::::::::Board::::::::::");
            Card[] random_board = new Card[3];
            for(int b=0; b<3; b++){
                Card ayudas = deckLeft.getCard(b);
                random_board[b] = new Card(ayudas.getRank(), ayudas.getSuit());
                //System.out.println(""+random_board[b].toString());
            }

            for(int na=0; na<5; na++){
                for(int crd=0; crd<5; crd++){
                    if(crd != na){
                        Card card_temp = playerOne.getCard(crd);
                        Card deepCopy = new Card(card_temp.getRank(), card_temp.getSuit());
                        temp_hand.addCard(deepCopy);
                    }
                }

                for(int brd=0; brd<3; brd++){
                    Card ayuda_temp = new Card(random_board[brd].getRank(), random_board[brd].getSuit());
                    temp_hand.addCard(ayuda_temp);
                    //System.out.println("Agrega la carta: " + ayuda_temp.toString());
                    //System.out.println(temp_hand.handToString());

                    evaluateHand(temp_hand);
                    //System.out.println("Evaluo y asigno el valor " + temp_hand.getHandRank()+ " a la mano: "+ temp_hand.handToString());

                    if(temp_hand.getHandRank() > best_hand_one.getHandRank()){
                        //System.out.println("Entro al if");
                        best_hand_one.deleteHand();
                        //System.out.println("Vacia best_hand_one y queda: "+ best_hand_one.handToString());

                        for(int dc=0; dc<5; dc++){
                            //System.out.println("Entra al for(dc) para deep copy");
                            Card best_card_temp = temp_hand.getCard(dc);
                            Card deepCopyBest = new Card(best_card_temp.getRank(), best_card_temp.getSuit());
                            best_hand_one.addCard(deepCopyBest);  
                        }
                        best_hand_one.setHandRank(temp_hand.getHandRank());
                        //System.out.println("Nueva Mejor mano: " + best_hand_one.handToString());
                    }else if(temp_hand.getHandRank() == best_hand_one.getHandRank()){
                        if(tieBreaker(temp_hand, best_hand_one) == 1){
                            best_hand_one.deleteHand();
                            for(int dc=0; dc<5; dc++){
                                Card best_card_temp = temp_hand.getCard(dc);
                                Card deepCopyBest = new Card(best_card_temp.getRank(), best_card_temp.getSuit());
                                best_hand_one.addCard(deepCopyBest);  
                            }
                            best_hand_one.setHandRank(temp_hand.getHandRank());
                        }
                    }
                    temp_hand.removeCard(ayuda_temp);
                    //System.out.println("Remueve la carta: " + ayuda_temp.toString() + " y queda: "+ temp_hand.handToString());
                }
                temp_hand.deleteHand();
                //System.out.println("borra temp_hand y queda: "+ temp_hand.handToString());
            } 


            for(int na=0; na<5; na++){
                for(int crd=0; crd<5; crd++){
                    if(crd != na){
                        Card card_temp_dos = playerTwo.getCard(crd);
                        Card deepCopyTwo = new Card(card_temp_dos.getRank(), card_temp_dos.getSuit());
                        temp_hand_two.addCard(deepCopyTwo);
                    }
                }
                for(int brd=0; brd<3; brd++){
                    Card ayuda_temp_dos = new Card(random_board[brd].getRank(), random_board[brd].getSuit());
                    temp_hand_two.addCard(ayuda_temp_dos);
                    evaluateHand(temp_hand_two);

                    if(temp_hand_two.getHandRank()> best_hand_two.getHandRank()){
                        best_hand_two.deleteHand();
                        for(int dc=0; dc<5; dc++){
                            Card best_card_temp2 = temp_hand_two.getCard(dc);
                            Card deepCopyBest2 = new Card(best_card_temp2.getRank(), best_card_temp2.getSuit());
                            best_hand_two.addCard(deepCopyBest2); 
                        }
                        best_hand_two.setHandRank(temp_hand_two.getHandRank());
                    }else if(temp_hand_two.getHandRank() == best_hand_two.getHandRank()){
                        if(tieBreaker(temp_hand_two, best_hand_two) == 1){
                            best_hand_two.deleteHand();
                            for(int dc=0; dc<5; dc++){
                                Card best_card_temp2 = temp_hand_two.getCard(dc);
                                Card deepCopyBest2 = new Card(best_card_temp2.getRank(), best_card_temp2.getSuit());
                                best_hand_two.addCard(deepCopyBest2);  
                            }
                            best_hand_two.setHandRank(temp_hand_two.getHandRank());
                        }
                    }
                    temp_hand_two.removeCard(ayuda_temp_dos);
                }
                temp_hand_two.deleteHand();
            } 



            //System.out.println(":" +best_hand_one.handToString()+ " Vs. " +best_hand_two.handToString()+" :");
            if(best_hand_one.getHandRank() > best_hand_two.getHandRank()){
                //System.out.println("Uno gana: " +best_hand_one.handToString()+ " contra: " +best_hand_two.handToString()+"\n");
                count_player_one_wins++;
            }if(best_hand_one.getHandRank() < best_hand_two.getHandRank()){
                 //System.out.println("Uno pierde: " +best_hand_one.handToString()+ " contra: " +best_hand_two.handToString()+"\n");
                count_player_two_wins++;
            }else if(best_hand_one.getHandRank() == best_hand_two.getHandRank()){
                 //System.out.println("Uno empata: " +best_hand_one.handToString()+ " contra: " +best_hand_two.handToString()+"\n");
                                                switch(tieBreaker(best_hand_one, best_hand_two)){
                    case 0: tie++; break;
                    case 1: count_player_one_wins++; break;
                    case 2: count_player_two_wins++; break;
                } 
            }

            best_hand_one.deleteHand();
            best_hand_two.deleteHand();

            temp_hand.deleteHand();
            temp_hand_two.deleteHand();

            playerOne.deleteHand();
            playerTwo.deleteHand();
            deckLeft.clearDeck();
        }      
        double hands_tied = (double)Math.round(tie)/100.0;

        System.out.println("Uno gana: "+count_player_one_wins);
        System.out.println("Dos gana: "+count_player_two_wins);
        System.out.println("ties: "+tie);

        double player_one_percentage = (double)Math.round(count_player_one_wins) / 100.0;
        double player_two_percentage = (double)Math.round(count_player_two_wins) / 100.0;

        labelResult.setText("Odds: "+player_one_percentage+"% vs "+player_two_percentage+"%  Tie: "+hands_tied+"%");
    } else {
        boardArray = board.split(",\\s*");
        if(boardArray.length > 3 ){
            JOptionPane.showMessageDialog(null, "The board must contain 3 cards max.", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            deck.removeCards(boardArray);

            for(int i=0; i<numberOfHands; i++){
                Hand playerOne = new Hand(handPlayerOne);
                Hand playerTwo = new Hand(handPlayerTwo);

                Deck deckLeft = new Deck(deck);
                deckLeft.shuffle();

                Hand temp_hand = new Hand();
                Hand temp_hand_two = new Hand();

                while(playerOne.getTotalCards() < 5){
                    playerOne.addCard(deckLeft.dealCard());
                }
                while(playerTwo.getTotalCards() < 5){
                    playerTwo.addCard(deckLeft.dealCard());
                }

                for(int dc=0; dc<5; dc++){
                    Card card_temp1 = playerOne.getCard(dc);
                    Card deepCopy1 = new Card(card_temp1.getRank(), card_temp1.getSuit());
                    best_hand_one.addCard(deepCopy1);  
                }
                for(int dc=0; dc<5; dc++){
                    Card card_temp2 = playerTwo.getCard(dc);
                    Card deepCopy2 = new Card(card_temp2.getRank(), card_temp2.getSuit());
                    best_hand_two.addCard(deepCopy2);  
                }

                best_hand_one.setHandRank(playerOne.getHandRank());
                best_hand_two.setHandRank(playerTwo.getHandRank());

                for(int na=0; na<5; na++){
                    for(int crd=0; crd<5; crd++){
                        if(crd != na){
                            Card card_temp = playerOne.getCard(crd);
                            Card deepCopy = new Card(card_temp.getRank(), card_temp.getSuit());
                            temp_hand.addCard(deepCopy);
                        }
                    }

                    for(int brd=0; brd<3; brd++){
                        Card ayuda_temp = new Card(boardArray[brd]);
                        temp_hand.addCard(ayuda_temp);

                        evaluateHand(temp_hand);

                        if(temp_hand.getHandRank() > best_hand_one.getHandRank()){
                            best_hand_one.deleteHand();

                            for(int dc=0; dc<5; dc++){
                                Card best_card_temp = temp_hand.getCard(dc);
                                Card deepCopyBest = new Card(best_card_temp.getRank(), best_card_temp.getSuit());
                                best_hand_one.addCard(deepCopyBest);  
                            }
                            best_hand_one.setHandRank(temp_hand.getHandRank());
                        } else if(temp_hand.getHandRank() == best_hand_one.getHandRank()){
                            if(tieBreaker(temp_hand, best_hand_one) == 1){
                                best_hand_one.deleteHand();
                                for(int dc=0; dc<5; dc++){
                                    Card best_card_temp = temp_hand.getCard(dc);
                                    Card deepCopyBest = new Card(best_card_temp.getRank(), best_card_temp.getSuit());
                                    best_hand_one.addCard(deepCopyBest);  
                                }
                                best_hand_one.setHandRank(temp_hand.getHandRank());
                            }
                        }
                        temp_hand.removeCard(ayuda_temp);
                    }
                    temp_hand.deleteHand();
                } 

                for(int na=0; na<5; na++){
                    for(int crd=0; crd<5; crd++){
                        if(crd != na){
                            Card card_temp_dos = playerTwo.getCard(crd);
                            Card deepCopyTwo = new Card(card_temp_dos.getRank(), card_temp_dos.getSuit());
                            temp_hand_two.addCard(deepCopyTwo);
                        }
                    }
                    for(int brd=0; brd<3; brd++){
                        Card ayuda_temp_dos = new Card(boardArray[brd]);
                        temp_hand_two.addCard(ayuda_temp_dos);
                        evaluateHand(temp_hand_two);

                        if(temp_hand_two.getHandRank()> best_hand_two.getHandRank()){
                            best_hand_two.deleteHand();
                            for(int dc=0; dc<5; dc++){
                                Card best_card_temp2 = temp_hand_two.getCard(dc);
                                Card deepCopyBest2 = new Card(best_card_temp2.getRank(), best_card_temp2.getSuit());
                                best_hand_two.addCard(deepCopyBest2); 
                            }
                            best_hand_two.setHandRank(temp_hand_two.getHandRank());
                        } else if(temp_hand_two.getHandRank() == best_hand_two.getHandRank()){
                            if(tieBreaker(temp_hand_two, best_hand_two) == 1){
                                best_hand_two.deleteHand();
                                for(int dc=0; dc<5; dc++){
                                    Card best_card_temp2 = temp_hand_two.getCard(dc);
                                    Card deepCopyBest2 = new Card(best_card_temp2.getRank(), best_card_temp2.getSuit());
                                    best_hand_two.addCard(deepCopyBest2);  
                                }
                                best_hand_two.setHandRank(temp_hand_two.getHandRank());
                            }
                        }
                        temp_hand_two.removeCard(ayuda_temp_dos);
                    }
                    temp_hand_two.deleteHand();
                } 

                if(best_hand_one.getHandRank() > best_hand_two.getHandRank()){
                    count_player_one_wins++;
                } if(best_hand_one.getHandRank() < best_hand_two.getHandRank()){
                    count_player_two_wins++;
                } else if(best_hand_one.getHandRank() == best_hand_two.getHandRank()){
                    switch(tieBreaker(best_hand_one, best_hand_two)){
                        case 0: tie++; break;
                        case 1: count_player_one_wins++; break;
                        case 2: count_player_two_wins++; break;
                    } 
                }

                best_hand_one.deleteHand();
                best_hand_two.deleteHand();

                temp_hand.deleteHand();
                temp_hand_two.deleteHand();

                playerOne.deleteHand();
                playerTwo.deleteHand();

                deckLeft.clearDeck(); 
            }
            double hands_tied = (double)Math.round(tie)/100.0;

            System.out.println("Uno gana: "+count_player_one_wins);
            System.out.println("Dos gana: "+count_player_two_wins);
            System.out.println("ties: "+tie);

            double player_one_percentage = (double)Math.round(count_player_one_wins) / 100.0;
            double player_two_percentage = (double)Math.round(count_player_two_wins) / 100.0;

            labelResult.setText("Odds: "+player_one_percentage+"% vs "+player_two_percentage+"%  Tie: "+hands_tied+"%");
        } 
    }
}//GEN-LAST:event_buttonCalculateActionPerformed

    /**
     * Evaluates the rank of the given hand.
     * 
     * @param playerHand the hand to evaluate
     */
    public void evaluateHand(Hand playerHand){
        if(playerHand.isPair()){
            switch(playerHand.whichKind()){
                case 1: 
                    if(playerHand.mataAces()){
                        playerHand.setHandRank(1);
                    } else {
                        playerHand.setHandRank(0);
                    }
                    break;  
                case 2: playerHand.setHandRank(2); break;
                case 3: playerHand.setHandRank(3); break;
                case 4: playerHand.setHandRank(6); break;
                case 6: playerHand.setHandRank(7); break;
            }
        } else {
            if(playerHand.isColor()){
                if(playerHand.isStraight()){
                    playerHand.setHandRank(8);
                } else {
                    playerHand.setHandRank(5);
                } 
            } else {
                if(playerHand.isStraight()){
                   playerHand.setHandRank(4);
                } else {
                    playerHand.setHandRank(0); 
                }
            }
        }
    }

    /**
     * Breaks ties between two hands of the same rank.
     * 
     * @param handOne the first hand
     * @param handTwo the second hand
     * @return 0 if tie, 1 if handOne wins, 2 if handTwo wins
     */
    public int tieBreaker(Hand handOne, Hand handTwo){
        switch(handOne.getHandRank()){
            case 0: return 0;
            case 1: return handOne.onePairTieBreak(handTwo);
            case 2: return handOne.twoPairTieBreak(handTwo);
            case 3: return handOne.terciaTieBreak(handTwo);
            case 4: return handOne.straightTieBreak(handTwo);     
            case 5: return handOne.colorTieBreak(handTwo);    
            case 6: return handOne.fullTieBreak(handTwo);      
            case 7: return handOne.pokerTieBreak(handTwo);   
            case 8: return handOne.straightTieBreak(handTwo);
        }
        return 0;
    }

    public static void main(String args[]) {

        try{ 
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName()); 
        } catch ( Exception e ){ 
            System.err.println( e ); 
        }

        java.awt.EventQueue.invokeLater(() -> new menuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalculate;
    private javax.swing.JButton buttonReset;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel labelBoard;
    private javax.swing.JLabel labelDeadCards;
    private javax.swing.JLabel labelOpponentOne;
    private javax.swing.JLabel labelResult;
    private javax.swing.JLabel labelYourCards;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JTextField textFieldBoard;
    private javax.swing.JTextField textFieldDeadCards;
    private javax.swing.JTextField textFieldHandOne;
    private javax.swing.JTextField textFieldHandTwo;
    // End of variables declaration//GEN-END:variables
}
