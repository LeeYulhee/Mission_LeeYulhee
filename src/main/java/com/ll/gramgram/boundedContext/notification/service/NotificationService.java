package com.ll.gramgram.boundedContext.notification.service;

import com.ll.gramgram.base.rsData.RsData;
import com.ll.gramgram.boundedContext.instaMember.entity.InstaMember;
import com.ll.gramgram.boundedContext.likeablePerson.entity.LikeablePerson;
import com.ll.gramgram.boundedContext.notification.entity.Notification;
import com.ll.gramgram.boundedContext.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public List<Notification> findByToInstaMember(InstaMember toInstaMember) {
        return notificationRepository.findByToInstaMember(toInstaMember);
    }

    // 작성 코드
    public RsData<Notification> create(LikeablePerson likeablePerson) {
        Notification notification = Notification
                .builder()
                .fromInstaMember(likeablePerson.getFromInstaMember())
                .toInstaMember(likeablePerson.getToInstaMember())
                .newAttractiveTypeCode(0)
                .oldAttractiveTypeCode(likeablePerson.getAttractiveTypeCode())
                .oldGender(likeablePerson.getFromInstaMember().getGenderDisplayName())
                .newGender(null)
                .typeCode("Like")
                .build();

        notificationRepository.save(notification);

        return RsData.of("S-1", "%s님이 호감 상대로 추가되었습니다".formatted(likeablePerson), notification);
    }

    public RsData<Notification> modifyAttractiveType(LikeablePerson likeablePerson, int oldAttractiveTypeCode) {
        InstaMember fromInstaMember = likeablePerson.getFromInstaMember();
        InstaMember toInstaMember = likeablePerson.getToInstaMember();

        Notification notification = Notification
                .builder()
                .fromInstaMember(fromInstaMember)
                .toInstaMember(toInstaMember)
                .newAttractiveTypeCode(likeablePerson.getAttractiveTypeCode())
                .oldAttractiveTypeCode(oldAttractiveTypeCode)
                .oldGender(fromInstaMember.getGenderDisplayName())
                .newGender(toInstaMember.getGenderDisplayName())
                .typeCode("ModifyAttractiveType")
                .build();

        notificationRepository.save(notification);

        return RsData.of("S-1", "%s님이 호감 사유를 변경하였습니다".formatted(likeablePerson), notification);
    }
}