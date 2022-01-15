package com.highthon.school.domain.interest.service;

import com.highthon.school.domain.interest.Interest;
import com.highthon.school.domain.interest.dto.InterestJabResponseDto;
import com.highthon.school.domain.interest.repository.InterestRepository;
import com.highthon.school.domain.job.repository.JabRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import com.highthon.school.global.exception.JabNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InterestService {
    private final InterestRepository interestRepository;
    private final JabRepository jabRepository;
    private final UserFacade userFacade;

    public void interestJab(String name){
        Interest interest = Interest.builder()
                                    .jab(jabRepository.findById(name).orElseThrow(JabNotFoundException::new))
                                    .user(userFacade.getCurrentUser()).build();
        if (interestCheck(userFacade.getCurrentUser().getId(), name)){
            interestRepository.delete(interest);
            return;
        }
        interestRepository.save(interest);
    }
    public List<InterestJabResponseDto> getInterestJab(){
        List<Interest> interests = interestRepository.findByUser(userFacade.getCurrentUser());
        List<InterestJabResponseDto> jabs = new ArrayList<>();
        for (Interest i : interests){
            jabs.add(
                    InterestJabResponseDto.builder()
                    .name(i.getJab().getName())
                    .intro(i.getJab().getIntro()).build()
            );
        }
        return jabs;
    }
    private boolean interestCheck(String userId, String jabName){
        Optional<Interest> interest = interestRepository.findByJab_NameAndUser_Id(jabName, userId);
        return interest.isPresent();
    }
}
