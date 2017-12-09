package housekeeper.entities;
// Generated 2017-12-9 17:20:53 by Hibernate Tools 5.2.5.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CardQueryId generated by hbm2java
 */
@Embeddable
public class CardQueryId  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = -5753156688528326449L;
	private int cardId;
     private String cardName;
     private String cardNumber;
     private Double money;
     private String remark;
     private int memberId;

    public CardQueryId() {
    }

	
    public CardQueryId(int cardId, int memberId) {
        this.cardId = cardId;
        this.memberId = memberId;
    }
    public CardQueryId(int cardId, String cardName, String cardNumber, Double money, String remark, int memberId) {
       this.cardId = cardId;
       this.cardName = cardName;
       this.cardNumber = cardNumber;
       this.money = money;
       this.remark = remark;
       this.memberId = memberId;
    }
   


    @Column(name="CARD_ID", nullable=false)
    public int getCardId() {
        return this.cardId;
    }
    
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }


    @Column(name="CARD_NAME")
    public String getCardName() {
        return this.cardName;
    }
    
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }


    @Column(name="CARD_NUMBER")
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Column(name="MONEY", precision=22, scale=0)
    public Double getMoney() {
        return this.money;
    }
    
    public void setMoney(Double money) {
        this.money = money;
    }


    @Column(name="REMARK")
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Column(name="MEMBER_ID", nullable=false)
    public int getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CardQueryId) ) return false;
		 CardQueryId castOther = ( CardQueryId ) other; 
         
		 return (this.getCardId()==castOther.getCardId())
 && ( (this.getCardName()==castOther.getCardName()) || ( this.getCardName()!=null && castOther.getCardName()!=null && this.getCardName().equals(castOther.getCardName()) ) )
 && ( (this.getCardNumber()==castOther.getCardNumber()) || ( this.getCardNumber()!=null && castOther.getCardNumber()!=null && this.getCardNumber().equals(castOther.getCardNumber()) ) )
 && ( (this.getMoney()==castOther.getMoney()) || ( this.getMoney()!=null && castOther.getMoney()!=null && this.getMoney().equals(castOther.getMoney()) ) )
 && ( (this.getRemark()==castOther.getRemark()) || ( this.getRemark()!=null && castOther.getRemark()!=null && this.getRemark().equals(castOther.getRemark()) ) )
 && (this.getMemberId()==castOther.getMemberId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCardId();
         result = 37 * result + ( getCardName() == null ? 0 : this.getCardName().hashCode() );
         result = 37 * result + ( getCardNumber() == null ? 0 : this.getCardNumber().hashCode() );
         result = 37 * result + ( getMoney() == null ? 0 : this.getMoney().hashCode() );
         result = 37 * result + ( getRemark() == null ? 0 : this.getRemark().hashCode() );
         result = 37 * result + this.getMemberId();
         return result;
   }   


}


