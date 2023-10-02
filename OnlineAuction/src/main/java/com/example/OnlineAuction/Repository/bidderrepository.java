package auction.demo.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import auction.demo.model.bidder;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface bidderrepository extends JpaRepository<bidder,Integer> {
    @Override
    public void flush() ;

    @Override
    public <S extends bidder> S saveAndFlush(S entity) ;
    @Override
    public <S extends bidder> List<S> saveAllAndFlush(Iterable<S> entities) ;

    @Override
    public void deleteAllInBatch(Iterable<bidder> entities);

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) ;

    @Override
    public void deleteAllInBatch() ;

    @Override
    public default bidder getOne(Integer integer) {
        return null;
    }

    @Override
    public default bidder getById(Integer integer) {
        return null;
    }

    @Override
    public default bidder getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public  <S extends bidder> Optional<S> findOne(Example<S> example) ;

    @Override
    public  <S extends bidder> List<S> findAll(Example<S> example);
    @Override
    public  <S extends bidder> List<S> findAll(Example<S> example, Sort sort) ;

    @Override
    public default <S extends bidder> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends bidder> long count(Example<S> example) ;

    @Override
    public <S extends bidder> boolean exists(Example<S> example) ;

    @Override
    public <S extends bidder, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    @Override
    public <S extends bidder> S save(S entity);

    @Override
    public <S extends bidder> List<S> saveAll(Iterable<S> entities) ;

    @Override
    public Optional<bidder> findById(Integer integer);
    @Override
    public boolean existsById(Integer integer) ;


    @Override
    public List<bidder> findAll() ;

    @Override
    public List<bidder> findAllById(Iterable<Integer> integers);

    @Override
    public long count() ;

    @Override
    public void deleteById(Integer integer) ;
    @Override
    public void delete(bidder entity) ;

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) ;

    @Override
    public void deleteAll(Iterable<? extends bidder> entities) ;

    @Override
    public void deleteAll() ;

    @Override
    public List<bidder> findAll(Sort sort) ;

    @Override
    public Page<bidder> findAll(Pageable pageable) ;
}
