package fr.emse.test;

import java.util.Vector;

public class MoneyBag {
    private Vector<Money> fMonies = new Vector<Money>();

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money bag[]) {
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }

    private void appendMoney(Money m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            // Parcours pour trouver si la devise existe déjà
            while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
                i++;
            if (i >= fMonies.size()) {
                fMonies.add(m); // Devise non trouvée, on ajoute un nouveau Money
            } else {
                // Devise trouvée, on additionne les montants
                Money existing = fMonies.get(i);
                fMonies.set(i, new Money(existing.amount() + m.amount(), m.currency()));
            }
        }
    }
    
    // Implémentez la méthode equals() (et hashCode())
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MoneyBag moneyBag = (MoneyBag) obj;
        // Compare les deux vecteurs. Cela nécessite que Money.equals() soit bien implémenté.
        return fMonies.equals(moneyBag.fMonies);
    }

    @Override
    public int hashCode() {
        return fMonies.hashCode();
    }
}