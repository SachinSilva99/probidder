package lk.probidder.dto.response.paginate;

import lk.probidder.dto.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedUserResponseDTO {
    private long dataCount;
    private List<UserResponseDTO> dataList = new ArrayList<>();
}
