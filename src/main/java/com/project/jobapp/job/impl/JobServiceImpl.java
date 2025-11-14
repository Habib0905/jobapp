package com.project.jobapp.job.impl;

import com.project.jobapp.job.Job;
import com.project.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
            return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        for(Job job: jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
                                                                                                                                }


}
