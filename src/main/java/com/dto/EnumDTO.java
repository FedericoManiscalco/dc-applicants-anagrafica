package com.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter

public class EnumDTO {

	List<EnumNameDTO> certificazione = new ArrayList<>(1);
	List<EnumNameDTO> laurea = new ArrayList<>(1);
	List<EnumNameDTO> contratto = new ArrayList<>(1);
	List<EnumNameDTO> diploma = new ArrayList<>(1);
	List<EnumNameDTO> livello = new ArrayList<>(1);
	List<EnumNameDTO> comeConosciuto = new ArrayList<>(1);
	List<EnumNameDTO> qualifica = new ArrayList<>(1);

}
