package com.project.jobapp.job.impl;

import com.project.jobapp.job.Job;
import com.project.jobapp.job.JobRepository;
import com.project.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepository repo;

    public JobServiceImpl(JobRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<Job> findAll() {
        return repo.findAll();
    }

    @Override
    public void createJob(Job job) {
        repo.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            repo.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }


    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = repo.findById(id);
            if(jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                return true;
            }

        return false;
    }


}