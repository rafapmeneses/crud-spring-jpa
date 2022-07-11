import './user-card.style.css'

export function UserCard ({ user, onClickUserDetails }){

  return(
    <button onClick={()=>onClickUserDetails(user.id)} className='user-card__content'>
      <h3>{user?.email}</h3> 
      <p>{user?.nome}</p>
    </button>
  )
}