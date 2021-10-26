package com.ensah.core.bo;



import java.util.*;
import com.ensah.core.bo.Utilisateur;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompte;

	
	private boolean accountNonExpired = true;

	private boolean accountNonLocked= true;

	private boolean credentialsNonExpired= true;

	private boolean enabled= true;

	private String login;

	private String password;

	private boolean disconnectAccount;

	private boolean accepteDemandeAutorisationAbsence;

	private boolean affichePhoto;

	private boolean afficheEmail;
	
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;

	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, targetEntity=Notification.class)
	private List<Notification> notifications;

	@OneToMany(mappedBy = "expediteur", cascade = CascadeType.ALL, targetEntity=Message.class)
	private List<Message> messagesEnvoyes;

	@OneToMany(mappedBy = "destinataire", cascade = CascadeType.ALL, targetEntity=Message.class)
	private List<Message> messagesRecus;

	@OneToMany(mappedBy = "createurConversation", cascade = CascadeType.ALL, targetEntity=Conversation.class)
	private List<Conversation> conversationsCrees;

	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, targetEntity=JournalisationEvenements.class)
	private List<JournalisationEvenements> evenements;

	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur proprietaire;

	@ManyToMany(mappedBy = "participant" , cascade = CascadeType.ALL)
	private List<Conversation> conversationRecues;

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isDisconnectAccount() {
		return disconnectAccount;
	}

	public void setDisconnectAccount(boolean disconnectAccount) {
		this.disconnectAccount = disconnectAccount;
	}

	public boolean isAccepteDemandeAutorisationAbsence() {
		return accepteDemandeAutorisationAbsence;
	}

	public void setAccepteDemandeAutorisationAbsence(boolean accepteDemandeAutorisationAbsence) {
		this.accepteDemandeAutorisationAbsence = accepteDemandeAutorisationAbsence;
	}

	public boolean isAffichePhoto() {
		return affichePhoto;
	}

	public void setAffichePhoto(boolean affichePhoto) {
		this.affichePhoto = affichePhoto;
	}

	public boolean isAfficheEmail() {
		return afficheEmail;
	}

	public void setAfficheEmail(boolean afficheEmail) {
		this.afficheEmail = afficheEmail;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Message> getMessagesEnvoyes() {
		return messagesEnvoyes;
	}

	public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
		this.messagesEnvoyes = messagesEnvoyes;
	}

	public List<Message> getmessagesRecus() {
		return messagesRecus;
	}

	public void setmessagesRecus(List<Message> messagesRecus) {
		this.messagesRecus = messagesRecus;
	}

	public List<Conversation> getConversationsCrees() {
		return conversationsCrees;
	}

	public void setConversationsCrees(List<Conversation> conversationsCrees) {
		this.conversationsCrees = conversationsCrees;
	}

	public List<JournalisationEvenements> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<JournalisationEvenements> evenements) {
		this.evenements = evenements;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur newUtilisateur) {
	      if (this.proprietaire == null || !this.proprietaire.equals(newUtilisateur))
	      {
	         if (this.proprietaire != null)
	         {
	            Utilisateur oldUtilisateur = this.proprietaire;
	            this.proprietaire = null;
	            oldUtilisateur.removeComptes(this);
	         }
	         if (newUtilisateur != null)
	         {
	            this.proprietaire = newUtilisateur;
	            this.proprietaire.addComptes(this);
	         }
	      }
	}

	public List<Conversation> getConversationRecues() {
		return conversationRecues;
	}

	public void setConversationRecues(List<Conversation> conversationRecues) {
		this.conversationRecues = conversationRecues;
	}

	
	
}