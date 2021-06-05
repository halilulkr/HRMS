package halilulkr.HRMS.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageService extends BaseService<JobSeekerCVImage, Integer> {
	Result addAndSave(JobSeekerCVImage jobSeekerImage, MultipartFile file);

	DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
