package demo2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
    private MemberRepository memberRepository;
	
    public List<MemberAccount> listAllMembers() {
        return memberRepository.findAll();
    }

    public void saveMember(MemberAccount member) {
    	memberRepository.save(member);
    }

    public MemberAccount getMember(Integer id) {
        return memberRepository.findById(id).get();
    }

    public void deleteMember(Integer id) {
    	memberRepository.deleteById(id);
    }
}
