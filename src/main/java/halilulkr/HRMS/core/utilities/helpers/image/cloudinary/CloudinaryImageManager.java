package halilulkr.HRMS.core.utilities.helpers.image.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sun.istack.FinalArrayList;

import halilulkr.HRMS.core.utilities.helpers.image.ImageService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;

//araştır

@Service
public class CloudinaryImageManager implements ImageService{

	private Environment environment;
	
	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryImageManager(final Environment environment) {
		this.environment = environment;
		cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name",
				environment.getProperty("cloudinary.cloud.name"),
				"api_key",
				environment.getProperty("cloudinary.api.key"),
				"api_secret",
				environment.getProperty("cloudinary.api.secret")));
	}

	@Override
	public DataResult<?> save(final MultipartFile file) {
		Map result;
		try {
			result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		} catch (final IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<Map>(e.getMessage());
		}

		return new SuccessDataResult<Map>(result);
	}
	
	
}
