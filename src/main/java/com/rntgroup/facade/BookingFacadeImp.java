package com.rntgroup.facade;

import com.rntgroup.model.Event;
import com.rntgroup.model.Ticket;
import com.rntgroup.model.User;
import com.rntgroup.service.EventService;
import com.rntgroup.service.TicketService;
import com.rntgroup.service.UserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingFacadeImp implements BookingFacade {

    EventService eventService;
    UserService userService;
    TicketService ticketService;

    public BookingFacadeImp(EventService eventService,
                            UserService userService,
                            TicketService ticketService) {
        this.eventService = eventService;
        this.userService = userService;
        this.ticketService = ticketService;
        System.out.println("Фасад " + this.getClass().getSimpleName() +
                " создан. Зависимости: " +
                eventService.getClass().getSimpleName() + ", " +
                userService.getClass().getSimpleName() + ", " +
                ticketService.getClass().getSimpleName() + ", " +
                " успешно внедрены");
    }

    @Override
    public Event getEventById(long eventId) {
        return eventService.findById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.findByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.findByDate(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.create(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.update(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return Objects.nonNull(eventService.deleteById(eventId));
    }

    @Override
    public User getUserById(long userId) {
        return userService.findById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.findByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.findByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userService.create(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.update(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return Objects.nonNull(userService.deleteById(userId));
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        Ticket ticket = new Ticket(0L, eventId, userId, category, place);
        return ticketService.create(ticket);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.findByUser(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.findByEvent(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return Objects.nonNull(ticketService.deleteById(ticketId));
    }
}
