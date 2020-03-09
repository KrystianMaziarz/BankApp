package pl.krystianmaziarz.bank.services.implementations;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.krystianmaziarz.bank.domain.User;
import pl.krystianmaziarz.bank.repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    private UserServiceImpl userServiceImpl;

    @Before
    public void setUp() throws Exception {
        userServiceImpl = new UserServiceImpl(userRepo);
    }
    @Test
    public void testShouldFindAllUsers() {
        //given
        User user = new User();
        User user2 = new User("Dawid", null , null, null, null ,null ,null ,null );
        User user3 = new User("Andrzej", null , null, null, null ,null ,null ,null );
        List<User> excepted = Lists.newArrayList(user, user2 , user3);
        Mockito.when(userRepo.findAll()).thenReturn(Lists.newArrayList(excepted));
        //when
        List<User> result = userServiceImpl.findAll();
        //then
        Assert.assertEquals(excepted , result);


    }
    @Test
    public void testShouldFindUserById() {
        //given
        User excepted = new User("Dawid", null , null, null, null ,null ,null ,null );
        excepted.setId(1L);
        Mockito.when(userRepo.getOne(1L)).thenReturn(excepted);
        //when
        User result = userServiceImpl.findById(1L);
        //then
        Assert.assertEquals(excepted, result);

    }
    @Test
    public void testShouldFindUserByEmail(){
        //given
        User excepted = new User("Dawid", null , "Dawid123@gmail.com", null, null ,null ,null ,null );
        Mockito.when(userRepo.findByEmail(Mockito.anyString())).thenReturn(excepted);
        //when
        User result = userServiceImpl.findByEmail("Dawid123@gmail.com");
        //then
        Assert.assertEquals(excepted , result);

    }
    @Test
    public void testShouldDeleteUserById() {
        //given



    }


}