package com.code.in.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChallengeService {
    private List<Challenge> Challenges =    //Create a separate class of challenges
            new ArrayList<>();
    private Long nextid = 1L;

    public ChallengeService() {// developer will enter the data
//            Challenge challenge1=new Challenge(1L,"January", "Learn a new programming language");
//            Challenges.add(challenge1 );
    }

    public List<Challenge> getAllChallenges() {
        return Challenges;
    }

    public boolean addchallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextid++);
            Challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }


    public Challenge getChallenge(String month) {


        for (Challenge challenge:Challenges){
            if (challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        for (Challenge challenge:Challenges){
            if (challenge.getId().equals(id)){
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            }
        }
        return false;
    }
    public boolean deteteChallenge(long id) {
        return Challenges.removeIf(challenge->challenge.getId().equals(id));
    }
}
