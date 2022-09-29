package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper;

import java.util.List;

/**
 *
 * @author emanuel.sousa
 *
 * @param <DTO>
 * @param <ENTITY>
 */

public interface EntityMapper<DTO, ENTITY> {

    /**
     * converter um DTO para uma ENTITY
     *
     * @author emanuel.sousa
     * @param dto
     * @return <ENTITY> entity
     */
    public ENTITY toEntity(DTO dto);

    /**
     * converter uma ENTITY para um DTO
     *
     * @author emanuel.sousa
     * @param entity
     * @return <DTO> dto
     */
    public DTO toDto(ENTITY entity);

    /**
     * converter uma List DTO para uma list ENTITY
     *
     * @author emanuel.sousa
     * @param dtoList
     * @return List<ENTITY> list entity
     */
    public List<ENTITY> toEntity(List<DTO> dtoList);

    /**
     * converter uma list ENTITY para uma lista DTO
     *
     * @author emanuel.sousa
     * @param entityList
     * @return List<DTO>
     */
    public List<DTO> toDto(List<ENTITY> entityList);


}
