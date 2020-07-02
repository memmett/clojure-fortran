module mod_helloworld
  use iso_c_binding
  implicit none
contains

  subroutine helloworld() bind(c)
    print *, 'Hello from Fortran!'
  end subroutine helloworld

  subroutine fsum(s, nx, x) bind(c)
    integer(c_int), intent(in   ), value :: nx
    real(c_double), intent(in   )        :: x(nx)
    real(c_double), intent(  out)        :: s
    s = sum(x)
  end subroutine fsum

end module mod_helloworld
