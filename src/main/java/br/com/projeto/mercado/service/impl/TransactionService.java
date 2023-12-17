package br.com.projeto.mercado.service.impl;

import br.com.projeto.mercado.models.report.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {


  public TransactionService() {
  }

  public List<Transaction> getTransactionList() {

    List<Transaction> transactionList = new ArrayList<>();

    Transaction transactionOne = new Transaction("2020/11/16", "11:18:26", "SITE TEST",
        "UNI001TEST - Basic2", "00003427 - PCP 3427", "UNI004AS - Salandy Aaron", "979548",
        "IDContribuyente01", "E1A1XONM - 000460", "UNI004AS - Salandy Aaron",
        "Card - 7095030162260000027", "Unleaded Plus ", 0.775, 2.25, 6.75);

    Transaction transactionTwo = new Transaction("2020/11/16", "11:18:26", "SITE TEST",
        "UNI001TEST - Basic2", "00003427 - PCP 3427", "UNI004AS - Salandy Aaron", "979548",
        "IDContribuyente01", "E1A1XONM - 000460", "UNI004AS - Salandy Aaron",
        "Card - 7095030162260000027", "Unleaded Plus ", 1.225, 3.55, 7.75);

    Transaction transactionThree = new Transaction("2020/11/17", "11:28:26", "SITE TEST",
        "UNI001TEST - Basic2", "00003427 - PCP 3427", "UNI004AS - JamilXT", "979548",
        "IDContribuyente02", "E1A1XONM - 000460", "UNI004AS - JamilXT",
        "Card - 7095030162260000027", "Unleaded Plus ", 1.775, 4.75, 8.75);

    Transaction transactionFour = new Transaction("2020/11/18", "12:28:26", "SITE TEST",
        "UNI001TEST - Basic3", "00003427 - PCP 3427", "UNI004AS - Faisal", "979548",
        "IDContribuyente03", "E1A1XONM - 000460", "UNI004AS - Faisal",
        "Card - 7095030162260000027", "Unleaded Plus ", 2.225, 5.95, 6.75);

    transactionList.add(transactionOne);
    transactionList.add(transactionTwo);
    transactionList.add(transactionThree);
    transactionList.add(transactionFour);

    return transactionList;
  }

}
