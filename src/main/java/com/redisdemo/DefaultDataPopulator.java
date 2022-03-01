package com.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DefaultDataPopulator implements ApplicationRunner {

    private final MeetingRepository meetingRepository;
    private final RedisTemplate redisTemplate;

    public DefaultDataPopulator(MeetingRepository meetingRepository, RedisTemplate redisTemplate) {
        this.meetingRepository = meetingRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Meeting meeting = new Meeting();
        meeting.setTitle("New Meeting");
        meeting.setStartAt(new Date());
        meetingRepository.save(meeting);

        meetingRepository.findAll().forEach(m -> {
            System.out.println("==============");
            System.out.println(m.getTitle() + ' ' + m.getStartAt());
        });
    }
}
