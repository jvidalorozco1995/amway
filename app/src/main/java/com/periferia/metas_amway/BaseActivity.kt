package com.periferia.metas_amway

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.periferia.metas_amway.goals.audios.views.AudioCreateGoal
import com.periferia.metas_amway.goals.audios.views.AudiosList
import com.periferia.metas_amway.goals.events.views.EventCreateGoal
import com.periferia.metas_amway.goals.events.views.EventsList
import com.periferia.metas_amway.goals.GoalsList
import com.periferia.metas_amway.goals.GoalsType
import com.periferia.metas_amway.goals.lectures.views.LectureGoalsAdd
import com.periferia.metas_amway.goals.lectures.views.LectureGoalsCreate
import com.periferia.metas_amway.goals.lectures.views.LectureGolasList
import com.periferia.metas_amway.goals.projects.views.ProjectsCreateGoal
import com.periferia.metas_amway.goals.projects.views.ProjectsList
import com.periferia.metas_amway.goals.training.views.TrainingCreateGoal
import com.periferia.metas_amway.goals.training.views.TrainingList

open class BaseActivity: AppCompatActivity(),  GoalsType.OnFragmentInteractionListener,
        GoalsList.OnFragmentInteractionListener,
        LectureGoalsCreate.OnFragmentInteractionListener,
        LectureGolasList.OnFragmentInteractionListener,
        LectureGoalsAdd.OnFragmentInteractionListener,
        ProjectsList.OnFragmentInteractionListener,
        ProjectsCreateGoal.OnFragmentInteractionListener,
        EventsList.OnFragmentInteractionListener,
        EventCreateGoal.OnFragmentInteractionListener,
        AudiosList.OnFragmentInteractionListener,
        AudioCreateGoal.OnFragmentInteractionListener,
        TrainingList.OnFragmentInteractionListener,
        TrainingCreateGoal.OnFragmentInteractionListener{

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}