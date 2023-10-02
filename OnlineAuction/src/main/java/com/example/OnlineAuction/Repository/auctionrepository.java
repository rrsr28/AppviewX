
package auction.demo.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import auction.demo.model.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository

public interface auctionrepository extends JpaRepository<Auction, Integer> {
    @Override
    public void flush();

    @Override
    public <S extends Auction> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    public void deleteAllInBatch(Iterable<Auction> entities);

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    public void deleteAllInBatch();

    @Override
    public Auction getOne(Integer integer);

    @Override
    public Auction getById(Integer integer);

    @Override
    public Auction getReferenceById(Integer integer);

    @Override
    public <S extends Auction> Optional<S> findOne(Example<S> example);

    @Override
    public <S extends Auction> List<S> findAll(Example<S> example);

    @Override
    public <S extends Auction> List<S> findAll(Example<S> example, Sort sort);

    @Override
    public <S extends Auction> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    public <S extends Auction> long count(Example<S> example);

    @Override
    public <S extends Auction> boolean exists(Example<S> example);

    @Override
    public <S extends Auction, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Override
    public <S extends Auction> S saveAndFlush(S entity);

    @Override
    public <S extends Auction> S save(S entity);

    @Override
    public <S extends Auction> List<S> saveAll(Iterable<S> entities);

    @Override
    public Optional<Auction> findById(Integer integer);

    @Override
    public boolean existsById(Integer integer);

    @Override
    public List<Auction> findAll();

    @Override
    public List<Auction> findAllById(Iterable<Integer> integers);

    @Override
    public long count();

    @Override
    public void deleteById(Integer integer);

    @Override
    public void delete(Auction entity);

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    public void deleteAll(Iterable<? extends Auction> entities);

    @Override
    public void deleteAll();

    @Override
    public List<Auction> findAll(Sort sort);

    @Override
    public Page<Auction> findAll(Pageable pageable);
}