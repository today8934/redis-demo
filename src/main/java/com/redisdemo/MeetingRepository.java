package com.redisdemo;

import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, String> {
}
