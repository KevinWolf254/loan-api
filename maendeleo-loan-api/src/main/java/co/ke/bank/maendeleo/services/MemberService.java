package co.ke.bank.maendeleo.services;

import co.ke.bank.maendeleo.entities.Member;
import co.ke.bank.maendeleo.exceptions.MemberNotFoundException;

public interface MemberService {

	public Member read(int identityNo) throws MemberNotFoundException;

}
