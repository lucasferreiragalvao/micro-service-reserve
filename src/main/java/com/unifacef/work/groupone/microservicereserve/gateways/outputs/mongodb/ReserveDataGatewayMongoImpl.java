package com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.ReserveDataGateway;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.documents.ReserveDocument;
import com.unifacef.work.groupone.microservicereserve.gateways.outputs.mongodb.repositories.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReserveDataGatewayMongoImpl implements ReserveDataGateway {

    private final ReserveRepository reserveRepository;

    @Override
    public Reserve save(Reserve reserve) {
        if(Objects.isNull(reserve.getCreatedDate())){
            reserve.setCreatedDate(LocalDateTime.now());
        }
        return reserveRepository.save(new ReserveDocument(reserve)).toDomain();
    }

    @Override
    public Optional<Reserve> findByCode(String code) {
        return reserveRepository.findById(code).map(ReserveDocument::toDomain);
    }

    @Override
    public Page<Reserve> findByPage(final Pageable pageable) {
        return reserveRepository.findAll(pageable).map(ReserveDocument::toDomain);
    }
}
