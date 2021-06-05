package halilulkr.HRMS.core.utilities.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import halilulkr.HRMS.core.utilities.results.DataResult;

public interface ImageService {

	DataResult<?> save(MultipartFile file);
}
