package com.code.windigitalcenter.service;

import com.code.windigitalcenter.entity.Activity;
import com.code.windigitalcenter.repository.ActivityRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ActivityService {

    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities(){
        return (List<Activity>) activityRepository.findAll();
    }

    public Activity save(Activity activity){
        return activityRepository.save(activity);
    }

    public void delete(Integer id){
        Long countById = activityRepository.count();
        if (countById == null || countById == 0){
            throw new UsernameNotFoundException("could not found a user with id : "+ id);
        }
        activityRepository.deleteById(id);
    }

}
