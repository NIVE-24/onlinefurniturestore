package com.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.IFeedbackRepository;
import com.service.CustomerFeedbackService;
import com.entity.Review;
import com.exception.CustomerFeedbackException;

/**
 * Author :Angel Jensi Prabha Dharmaraj 
 * Date :14-09-2021 
 * Description:This is Review Service Class that provide services to add a review, remove a
 *  review, update a review and to view review details
 **/
@Service
@Transactional
public class FeedbackService implements CustomerFeedbackService {

	Logger logger = Logger.getLogger(FeedbackService.class);
	@Autowired
	private IFeedbackRepository feedbackRepository;

	/**
	 * Description :To add Review to the database 
	 * Input Params :Review object to be added to the database 
	 * Return Value :Review object 
	 * Exception : CustomerFeedbackException - It is raised when Review already exist
	 * 
	 * @throws CustomerFeedbackException
	 **/
	@Override
	public Review addReview(Review review) throws CustomerFeedbackException {
		Review addReview;
		logger.info("Fetching Review inprogress...");
		addReview = feedbackRepository.save(review);
		logger.info("Review details are: " + addReview);
		return addReview;
	}

	/**

	*Description	:To update Review details to the database
	*Input Params	:Review to be updated in the database
	*Return Value	:Review object of the Furniture been updated
	*Exception	:CustomerFeedbackException-It is raised when Review doesn't exist   
	*
	*@throws CustomerFeedbackException
	**/
	@Override
	public Review updateReview(int feedBackId, Review review) throws CustomerFeedbackException {
		Review updReview;
		try {
			logger.info("Update Review inprogress...");
			review = feedbackRepository.findById(feedBackId).orElse(null);
			if (review.getReviewId() == feedBackId) {
				updReview = feedbackRepository.save(review);
				logger.info("Updated Review details: " + updReview);
			} else {
				throw new CustomerFeedbackException("Id no found");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("id not found");
		}
		return updReview;
	}

	/**
	*Description	:To fetch Review details from the database
	*Input Params	:Review ID object to be fetched from the database
	*Return Value	:Review object of the Furniture been fetched
	*Exception	:CustomerFeedbackException-It is raised when Review Id doesn't exist 
	*
	*  @throws CustomerFeedbackException
	**/
	
	@Override
	public Review viewReview(int feedBackId) throws CustomerFeedbackException {

		Review getReview;
		try {
			logger.info("View Review inprogress...");
			getReview = feedbackRepository.findById(feedBackId).orElse(null);
			if (getReview.getReviewId()== feedBackId) {
				getReview = feedbackRepository.findById(feedBackId).orElse(null);
				logger.info("Review details: " + getReview);
			} else {
				throw new CustomerFeedbackException("Id is not found");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("Id is not found");
		}
		return getReview;
	}

	/**
	 * Description : To fetch all Review details from the database 
	 * Return Value :List<Review> object of the furniture been fetched
	 *  Exception : CustomerFeedbackException - It is raised when Review is empty
	 * 
	 * @throws CustomerFeedbackException
	 **/
	@Override
	public List<Review> viewAllReview() throws CustomerFeedbackException {
		List<Review> getReview;
		try {
			logger.info("View All Review inprogress...");
			getReview = feedbackRepository.findAll();
			if (!getReview.isEmpty()) {
				logger.info("Review details: " + getReview);
				return getReview;
			} else {
				throw new CustomerFeedbackException("There is no values in thre review");
			}
		} catch (Exception e) {
			throw new CustomerFeedbackException("There is no value in the review");
		}
	}

}
